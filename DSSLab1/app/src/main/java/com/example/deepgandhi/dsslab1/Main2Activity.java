package com.example.deepgandhi.dsslab1;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main2Activity extends AppCompatActivity implements OnLoadCompleteListener, OnPageChangeListener, OnErrorListener {

    PDFView pdfView;
    Button btnnext,btnprev;
    int totalPages = 0;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pdfView = findViewById(R.id.pdfView);
        btnnext = findViewById(R.id.btnNextPdf);
        btnprev = findViewById(R.id.btnPrevPdf);
        pdfView.fromAsset("sample.pdf")
                .enableSwipe(false)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .onLoad(this)
                .onPageChange(this)
                .onError(this)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .load();



        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if(counter <= totalPages){
                    pdfView.jumpTo(counter);
                }
            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter--;
                if(counter >= 0){
                    pdfView.jumpTo(counter);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void loadComplete(int nbPages) {
        totalPages = nbPages;
    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void onError(Throwable t) {

    }
}
