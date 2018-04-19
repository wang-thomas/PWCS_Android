package com.whartonsummit.android_app.pwcs_android.Activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.whartonsummit.android_app.pwcs_android.Models.Contact;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Services.DataService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContactDetailsActivity extends AppCompatActivity {

    Contact contact;

    @BindView(R.id.email_text) TextView email;
    @BindView(R.id.phone_text) TextView phone;
    @BindView(R.id.copy_email_btn) ImageButton copyEmailBtn;
    @BindView(R.id.copy_phone_btn) ImageButton copyPhoneBtn;
    @BindView(R.id.add_or_delete) Button actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        contact = (Contact) intent.getSerializableExtra("contact");

        setUpToolbar();
        email.setText(contact.getEmail());
        phone.setText(contact.getPhone());
        copyEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copyToClipboard("email", contact.getEmail());
            }
        });
        copyPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copyToClipboard("phone", contact.getPhone());
            }
        });
        setActionButton();
    }

    private void setActionButton() {
        if (DataService.getInstance().realmContains(contact)) {
            actionButton.setText("Delete Contact");
            actionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataService.getInstance().deleteContact(contact);
                    actionButton.setText("Add Contact");
                }
            });
        } else {
            actionButton.setText("Add Contact");
            actionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataService.getInstance().addContact(contact);
                    actionButton.setText("Delete Contact");
                }
            });
        }
    }

    private void copyToClipboard(String label, String content) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText(label, content);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "'" + content + "' copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    private void setUpToolbar() {
        setTitle(contact.getFirstName() + " " + contact.getLastName());
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }
}
