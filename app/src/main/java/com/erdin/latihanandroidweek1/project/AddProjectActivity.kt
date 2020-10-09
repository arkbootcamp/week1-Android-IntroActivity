package com.erdin.latihanandroidweek1.project

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.erdin.latihanandroidweek1.R
import com.erdin.latihanandroidweek1.databinding.ActivityAddProjectBinding
import com.erdin.latihanandroidweek1.mvp.ProjectsApiService
import com.erdin.latihanandroidweek1.remote.ApiClient
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File


class AddProjectActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddProjectBinding
    private lateinit var viewModel: AddProjectViewModel

    companion object {
        //image pick code
        private const val IMAGE_PICK_CODE = 1000;
        //Permission code
        private const val PERMISSION_CODE = 1001;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_project)
        viewModel = ViewModelProvider(this).get(AddProjectViewModel::class.java)
        val service = ApiClient.getApiClient(this)?.create(ProjectsApiService::class.java)
        if (service != null) {
            viewModel.setLoginService(service)
        }

        binding.btnPickImage.setOnClickListener {
            //check runtime permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                    //permission denied
                    val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
                    //show popup to request runtime permission
                    requestPermissions(permissions, PERMISSION_CODE);
                }
                else{
                    //permission already granted
                    pickImageFromGallery();
                }
            }
            else{
                //system OS is < Marshmallow
                pickImageFromGallery();
            }
        }



    }

    private fun pickImageFromGallery() {
        //Intent to pick image
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    //handle requested permission result
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                    //permission from popup granted
                    pickImageFromGallery()
                }
                else{
                    //permission from popup denied
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //handle result of picked image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE){
            binding.imageView.setImageURI(data?.data)

            val filePath = getPath(this, data?.data)
            val file = File(filePath)

            var img: MultipartBody.Part? = null
            val mediaTypeImg = "image/jpeg".toMediaType()
            val inputStream = contentResolver.openInputStream(data?.data!!)
            val reqFile: RequestBody? = inputStream?.readBytes()?.toRequestBody(mediaTypeImg)

            val name = createPartFromString("Pembuatan Web Company PT Sentosa Abadi")
            val description = createPartFromString("Pembuatan Web Company PT Sentosa Abadi")
            val price = createPartFromString("5000000")
            val duration = createPartFromString("6 Month")

            img = reqFile?.let { it1 ->
                MultipartBody.Part.createFormData("image", file.name,
                    it1
                )
            }

            binding.btnSubmit.setOnClickListener {
                if (img != null) {
                    viewModel.postProjectApi(name, description, price, duration, img)
                }
            }
        }

    }

    fun getPath(context: Context, uri: Uri?): String {
        var result: String? = null
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor? =
            uri?.let { context.contentResolver.query(it, proj, null, null, null) }
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                val column_index = cursor.getColumnIndexOrThrow(proj[0])
                result = cursor.getString(column_index)
            }
            cursor.close()
        }
        if (result == null) {
            result = "Not found"
        }
        return result
    }

    @NonNull
    private fun createPartFromString(json: String): RequestBody {
        val mediaType = "multipart/form-data".toMediaType()
        return json
            .toRequestBody(mediaType)
    }

}