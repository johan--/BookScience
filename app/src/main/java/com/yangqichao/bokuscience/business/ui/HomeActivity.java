/*
* Copyright (C) 2016 Pedro Paulo de Amorim
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.yangqichao.bokuscience.business.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.folioreader.activity.FolioActivity;
import com.yangqichao.bokuscience.R;

public class HomeActivity extends AppCompatActivity {
    private static final int GALLERY_REQUEST = 102;


    public static final String[] WRITE_EXTERNAL_STORAGE_PERMS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.btn_assest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(HomeActivity.this, WRITE_EXTERNAL_STORAGE_PERMS, GALLERY_REQUEST);
//                } else {
//                    //openEpub(FolioActivity.EpubSourceType.ASSESTS,"PhysicsSyllabus.epub",0);
//                    openEpub(FolioActivity.EpubSourceType.ASSESTS,"149600.epub",0);
//                }
            }
        });

        findViewById(R.id.btn_raw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(HomeActivity.this, WRITE_EXTERNAL_STORAGE_PERMS, GALLERY_REQUEST);
//                } else {
//                    openEpub(FolioActivity.EpubSourceType.RAW,null,R.raw.adventures);
//                }
            }
        });
    }


    private void openEpub(FolioActivity.EpubSourceType sourceType, String path, int rawID) {
        Intent intent = new Intent(HomeActivity.this, FolioActivity.class);
        if(rawID!=0) {
            intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, rawID);
        } else {
            intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_PATH, path);
        }
        intent.putExtra(FolioActivity.INTENT_EPUB_SOURCE_TYPE, sourceType);
        startActivity(intent);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case GALLERY_REQUEST:
                if (grantResults != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //openEpub();
                } else {
                    Toast.makeText(this, "Cannot open epub it needs storage access !", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /*private static class TestFragmentAdapter extends FragmentPagerAdapter {

        protected static final String[] CONTENT = new String[] { "This", "Is Is", "A A A", "Test", };

        public TestFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(CONTENT[position]);
        }

        @Override
        public int getCount() {
            return CONTENT.length;
        }

    }*/
}