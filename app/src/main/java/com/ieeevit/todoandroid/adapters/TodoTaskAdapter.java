package com.ieeevit.todoandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ieeevit.todoandroid.R;
import com.ieeevit.todoandroid.ShowTaskActivity;
import com.ieeevit.todoandroid.models.TodoTask;
import android.view.View;

import java.util.ArrayList;

/**
 * Adapter for the RecyclerView that displays the tasks in the Main Activity.
 */
public class TodoTaskAdapter extends RecyclerView.Adapter<TodoTaskAdapter.TodoTaskHolder> {

    /**
     * This list holds the tasks.
     */
    Context context;
    private ArrayList<TodoTask> tasks;

    /**
     * Denotes which item of the view is selected.
     * If checkedPosition = -1, there is no default selection.
     * If checkedPosition = 0, 1st item is selected by default
     */
    private int checkedPosition = -1;

    class TodoTaskHolder extends RecyclerView.ViewHolder {

        /**
         * This TextView shows the title of the task.
         */
        private TextView titleTextView;

        /**
         * This TextView shows the deadline for the task.
         */
        private TextView deadlineTextView;

        /**
         * Selected tick mark.
         */
        private ImageView checkedImageView;

        /**
         * Constructor for the class.
         * @param itemView
         */
        public TodoTaskHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.task_title);
            deadlineTextView = itemView.findViewById(R.id.task_deadline);
            checkedImageView=itemView.findViewById(R.id.imageView);
        }

        /**
         * Binds the task and sets the details of the task in the views.
         */
        void bindSetDetail(final TodoTask task) {
            // Set the visibility of the checkedImageView based on the value of checkedPosition.
            titleTextView.setText(task.getTaskTitle());
            deadlineTextView.setText((CharSequence) task.getTaskDeadline());
            // Also set the deadline

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getSelectedIndex()==-1) {
                        checkedPosition = getAdapterPosition();
                        Intent intent = new Intent(context, ShowTaskActivity.class);
                        intent.putExtra("TodoTask", getSelected());
                        context.startActivity(intent);
                    }
                    // Implement the logic of displaying that task's details.
                    // The ShowTaskActivity can be used for this
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    if(getSelectedIndex()==-1) {
                        checkedPosition = getAdapterPosition();
                        checkedImageView.setVisibility(View.VISIBLE);
                        notifyItemChanged(getAdapterPosition());
                    }
                    // Set the visibility of the checkedImageView by checking the checked index
                    // Don't forget to call notifyItemChanged() with the checkedPosition as argument
                    return true;
                }
            });
        }
    }

    /**
     * Constructor for the adapter.
     * @param tasks the list of TodoTasks.
     */
    public TodoTaskAdapter(ArrayList<TodoTask> tasks, Context context) {
        this.context=context;
        this.tasks = tasks;
    }

    /**
     * Sets the list of tasks.
     * @param tasks the tasks to be set
     */
    public void setTasks(ArrayList<TodoTask> tasks) {
        this.tasks=tasks;
        notifyDataSetChanged();
        // Set the tasks list of this object to the parameter.
        // Don't forget to call notifyDataSetChanged()
    }

    @Override
    public void onBindViewHolder(@NonNull TodoTaskHolder holder, int position) {
        // Retrieve a TodoTask instance by using holder.get(position)
        // Then set the details of the holder using that retrieved instance of TodoTask
        TodoTask todoTask = tasks.get(position);
        holder.bindSetDetail(todoTask);
    }

    @NonNull
    @Override
    public TodoTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Use layout inflater to get a view
        // Then make a TodoTaskHolder with that view and return it

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new TodoTaskHolder(itemView);
    }

    /**
     * Returns the number of items.
     * @return
     */
    @Override
    public int getItemCount() {
        // Return the length of the tasks list.
        return tasks.size();
    }

    /**
     * Returns the selected TodoTask
     * @return the selected TodoTask
     */
    public TodoTask getSelected() {
        // Check the checkedPosition and get the TodoTask object at that position in the list
        // and return it
        return tasks.get(checkedPosition);
    }

    /**
     * Returns the selected TodoTask's index in the ArrayList
     * @return the selected TodoTask's index in the ArrayList
     */
    public int getSelectedIndex() {

        // Check the checkedPosition and get the position
        // and return it
        return checkedPosition;
    }
}
