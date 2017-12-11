package my.edu.tarc.saveimage.Adaptor;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import my.edu.tarc.saveimage.Model.ImageFile;
import my.edu.tarc.saveimage.R;

/**
 * Created by KweeTeck on 11/1/2017.
 */

public class ImageAdaptor extends ArrayAdapter<ImageFile> {
    private final List<ImageFile> list;
    Activity context;

    public ImageAdaptor(Activity context, int resource,  List<ImageFile> list) {
        super(context, resource, list);
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater  = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.image_layout, parent, false);

        TextView textViewID = (TextView) rowView.findViewById(R.id.textViewID);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);

        ImageFile imageFile;
        imageFile = getItem(position);

        textViewID.setText("ID:"+ imageFile.getId());
        return rowView;
    }
}
