package dev.azertim.orange_toolbox.ui.reseau.oneaccess;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dev.azertim.orange_toolbox.R;

public class OneaccessCommandsFragment extends Fragment {
    private LinearLayout commandContainer;
    private LinearLayout descriptionContainer;

    public OneaccessCommandsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_oneaccess_commands, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commandContainer = view.findViewById(R.id.commandContainer);

        List<String[]> oneaccessCommands = getOneaccessCommands();
        for (String[] command : oneaccessCommands) {
            View commandView = LayoutInflater.from(requireContext()).inflate(R.layout.item_oneaccess_command, commandContainer, false);

            TextView titleTextView = commandView.findViewById(R.id.commandTitleTextView);
            TextView descriptionTextView = commandView.findViewById(R.id.commandDescriptionTextView);

            titleTextView.setText(command[0]);
            descriptionTextView.setText(command[1]);

            commandContainer.addView(commandView);
        }
    }




    private List<String[]> getOneaccessCommands() {
        List<String[]> commands = new ArrayList<>();

        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.oneaccess_commands);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String[] command = { parts[0].trim(), parts[1].trim() };
                    commands.add(command);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return commands;
    }
}