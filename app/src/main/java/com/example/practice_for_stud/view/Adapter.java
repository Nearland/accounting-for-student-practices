package com.example.practice_for_stud.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.example.practice_for_stud.App;
import com.example.practice_for_stud.R;
import com.example.practice_for_stud.model.Students;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.NoteViewHolder> {

    private SortedList<Students> sortedList;

    /**
     * Сортировка задач
     */
    public Adapter() {// сортировка задач

        sortedList = new SortedList<>(Students.class, new SortedList.Callback<Students>() {

            @Override
            public int compare(Students o1, Students o2) {// сравниватель
                return (int) (o2.timestamp - o1.timestamp);
            }

            @Override
            public void onChanged(int position, int count) {// менятель
                notifyItemRangeChanged(position, count);

            }

            @Override
            public boolean areContentsTheSame(Students oldItem, Students newItem) {// когда содержиое одинаково
                return oldItem.equals(newItem);
            }

            @Override
            public boolean areItemsTheSame(Students item1, Students item2) {
                return item1.id == item2.id;
            }

            @Override
            public void onInserted(int position, int count) {
                notifyItemRangeInserted(position, count);
            }

            @Override
            public void onRemoved(int position, int count) {
                notifyItemRangeRemoved(position, count);
            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {
                notifyItemMoved(fromPosition, toPosition);
            }
        });
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.students_details_list, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(sortedList.get(position));
    }


    @Override
    public int getItemCount() {
        return sortedList.size();
    }

    public void setItems(List<Students> notes) {
        sortedList.replaceAll(notes);
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView name, surname, patronymic;
        View delete;
        Students students;
        boolean silentUpdate;

        public NoteViewHolder(@NonNull final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tt_name);
            surname = itemView.findViewById(R.id.tt_surname);
            patronymic = itemView.findViewById(R.id.tt_patronymic);
            delete = itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment_students.start((Activity) itemView.getContext(), students);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    App.getInstance().getNoteDao().delete(students);
                }
            });

        }

        public void bind(Students note) {
            this.students = note;
            name.setText(note.nameS);
            surname.setText(note.surnameS);
            patronymic.setText(note.patronymicS);

        }

    }

}