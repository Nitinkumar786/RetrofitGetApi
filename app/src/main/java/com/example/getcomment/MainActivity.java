package com.example.getcomment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private JsonHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         jsonPlaceHolderApi = retrofit.create(JsonHolderApi.class);
        gettComment();

    }
    private void gettComment() {
        Call<List<Comment>> call = jsonPlaceHolderApi.getComment(3);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (!response.isSuccessful())
                {
                    textView.setText("code"+response.code());
                    return;
                }
                List<Comment> comments =  response.body();
                for (Comment post : comments)

                    {
                        String content ="";
                        content += "ID:" + post.getId() + "\n";
                        content += "postId:" + post.getPostId() + "\n";
                        content += "name:" + post.getName() + "\n";
                        content += "email:" + post.getEmail() + "\n\n";
                        content += "Text:" + post.getText() + "\n\n";
                        textView.append(content);
                    }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {

            }
        });
    }
}