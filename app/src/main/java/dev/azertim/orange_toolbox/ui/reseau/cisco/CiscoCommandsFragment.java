package dev.azertim.orange_toolbox.ui.reseau.cisco;

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

public class CiscoCommandsFragment extends Fragment {

    private LinearLayout commandContainer;
    private LinearLayout descriptionContainer;

    public CiscoCommandsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cisco_commands, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        commandContainer = view.findViewById(R.id.commandTitleTextView);
        descriptionContainer = view.findViewById(R.id.commandDescriptionTextView);

        List<String[]> ciscoCommands = getCiscoCommands();
        for (String[] command : ciscoCommands) {
            TextView titleTextView = new TextView(requireContext());
            titleTextView.setText(command[0]);
            commandContainer.addView(titleTextView);

            TextView descriptionTextView = new TextView(requireContext());
            descriptionTextView.setText(command[1]);
            descriptionContainer.addView(descriptionTextView);
        }
    }

    private List<String[]> getCiscoCommands() {
        List<String[]> commands = new ArrayList<>();

        Resources resources = getResources();
        InputStream inputStream = resources.openRawResource(R.raw.cisco_commands);

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
