package com.example.profile.adapterexamples

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


/// we may use differ
class ExampleAdapter(private val data: ArrayList<Any>, private val exampleClickListener: ExampleAdapter.ExampleClickListener) :

    RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ExampleViewHolder(private val view: View, var binding: ExampleBinding) : RecyclerView.ViewHolder(view){


        fun bindData(binding: ViewBinding, data: Any, buttonClickListener: ExampleClickListener) {
            //do binding here
            binding.yy.text = data.title

            binding.xx.setOnClickListener {
                buttonClickListener.onCalendarItemClicked()
            }
        }
    }

    // Button click listener implemented via this interface
    interface ExampleClickListener{
        fun onCalendarItemClicked()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        // create a new view
        val binding = ExampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ExampleViewHolder(binding.root, binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bindData(holder.binding, data[position], calendarButtonClickListener)
    }




    //Adds element to the dataset
    fun submitElements(list: List<CalendarItem>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }


    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.size
}