package com.whartonsummit.android_app.pwcs_android.Fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.whartonsummit.android_app.pwcs_android.Models.Contact;
import com.whartonsummit.android_app.pwcs_android.R;
import com.whartonsummit.android_app.pwcs_android.Services.DataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class PersonalFragment extends android.support.v4.app.Fragment {

    EditText firstNameField;
    EditText lastNameField;
    EditText phoneField;
    EditText emailField;
    Button updateBtn;

    ImageView qrcode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personal, container, false);
        firstNameField = rootView.findViewById(R.id.first_name_edit);
        lastNameField = rootView.findViewById(R.id.last_name_edit);
        phoneField = rootView.findViewById(R.id.phone_number_edit);
        emailField = rootView.findViewById(R.id.email_edit);
        updateBtn = rootView.findViewById(R.id.update_btn);
        qrcode = rootView.findViewById(R.id.qrcode);
        qrcode.setVisibility(View.INVISIBLE);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateInfo();
            }
        });
        setInfo();
        return rootView;
    }

    private void setInfo() {
        Contact me = DataService.getInstance().getDefaultContact(getActivity());
        firstNameField.setText(me.getFirstName());
        lastNameField.setText(me.getLastName());
        phoneField.setText(me.getPhone());
        emailField.setText(me.getEmail());
        if (infoValidated()) {
            Bitmap bitmap = encodeInfo(me);
            qrcode.setImageBitmap(bitmap);
            qrcode.setVisibility(View.VISIBLE);
        }
    }

    private void updateInfo() {
        if (infoValidated()) {
            String firstName = firstNameField.getText().toString();
            String lastName = lastNameField.getText().toString();
            String phone = phoneField.getText().toString();
            String email = emailField.getText().toString();
            Contact contact = new Contact(firstName, lastName, phone, email);
            DataService.getInstance().writeUserContact(getActivity(), contact);
            Bitmap bitmap = encodeInfo(contact);
            qrcode.setImageBitmap(bitmap);
            qrcode.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(getContext(), "Empty Field", Toast.LENGTH_SHORT).show();
            qrcode.setVisibility(View.INVISIBLE);
        }
    }

    private boolean infoValidated() {
        return !firstNameField.getText().toString().equals("") &&
                !lastNameField.getText().toString().equals("") &&
                !phoneField.getText().toString().equals("") &&
                !emailField.getText().toString().equals("") &&
                emailField.getText().toString().contains("@");
    }

    private Bitmap encodeInfo(Contact contact) {
        String encoding = contact.encode();
        try {
            return encodeAsBitmap(encoding);
        } catch (WriterException e) {
            Toast.makeText(getContext(), "QRCode Failed:", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, 600, 600, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, 600, 0, 0, w, h);
        return bitmap;
    }

}