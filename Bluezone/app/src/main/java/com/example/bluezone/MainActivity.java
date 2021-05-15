package com.example.bluezone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btbppd, bt_kbyt, bt_TinTuc, bt_map, bt_faq;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent tintuc = new Intent(MainActivity.this, TinTuc.class);
        Intent bppb = new Intent(MainActivity.this, BBPD.class);
        Intent IntTFAQ = new Intent(MainActivity.this, FAQ.class);
        Intent KBYT = new Intent(MainActivity.this, KhaiBaoYTe.class);
        //Intent SoDoDich = new Intent(getApplicationContext(), SoDo.class);
        buildNotification(tintuc, "Tin tức covid", "Nhấn vào để xem những thông tin cập nhật mới nhất về Covid", 1);
        buildNotification(KBYT, "Khai Báo Y Tế ngay!","Hãy khai báo y tế để giúp cộng đồng cùng vượt qua dịch Covid nhé!", 2);
        buildNotification(IntTFAQ, "Tìm hiểu Bluezone ngay!","Xem những câu hỏi thường gặp và giải đáp thắc mắc về Bluezone!", 3);
        buildNotification(bppb, "Xem ngay những biện pháp phòng Covid!","Xem video về cách phòng dịch nhé!", 4);
        //buildNotification();

        AnhXa();
        // Chức năng xem phòng chống dịch bệnh
        btbppd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), BBPD.class);
                buildNotification(intent1, "Đang xem biện pháp phòng dịch", "Hãy xem và thực hiện theo đúng nhé!", 5);

                Intent BPPD = new Intent(MainActivity.this, BBPD.class);
                startActivity(BPPD);
            }
        });

        // Chức năng xem thông tin dịch bệnh
        bt_TinTuc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), TinTuc.class);
                buildNotification(intent1, "Đang xem tin tức", "Thông tin mới nhất về Covid", 6);

                Intent intent = new Intent(MainActivity.this, TinTuc.class);
                startActivity(intent);
            }
        });

        bt_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), FAQ.class);
                buildNotification(intent1, "Đang xem Hỏi Đáp về Bluezone","Hãy cùng tìm hiểu về Bluezone nhé!", 7);

                Intent intent = new Intent(MainActivity.this, FAQ.class);
                startActivity(intent);
            }
        });

        bt_kbyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1  = new Intent(getApplicationContext(), KhaiBaoYTe.class);
                buildNotification(intent1, "Bạn đang khai báo y tế!","Khai báo đúng thông tin để giúp cộng đồng cùng chống đại dịch Covid", 8);

                Intent intent = new Intent(MainActivity.this, KhaiBaoYTe.class);
                startActivity(intent);
            }
        });
    }

    public void AnhXa(){
        bt_kbyt = findViewById(R.id.btn_kbyt);
        bt_faq = findViewById(R.id.btn_report);
        bt_TinTuc = findViewById(R.id.btn_tintuc);
        bt_map = findViewById(R.id.btn_map);
        btbppd = findViewById(R.id.btn_bppb);
    }

    private void buildNotification(Intent intent, String ContTitle, String ContText, int requestCode) {
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(), requestCode, intent, 0);
        Notification.Builder builder = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.drawable.item_blue)
                .setContentTitle(ContTitle)
                .setContentText(ContText)
                .setDeleteIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(100, builder.build());
    }
}
