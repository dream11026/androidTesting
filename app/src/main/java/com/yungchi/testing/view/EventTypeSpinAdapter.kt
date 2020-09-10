package com.yungchi.testing.view

import android.content.Context
import com.yungchi.testing.BR
import com.yungchi.testing.R
import com.yungchi.testing.databinding.EventTypeListItemBinding
import com.yungchi.testing.model.EventTypeSpinModel

class EventTypeSpinAdapter(
    context: Context,
    data: List<EventTypeSpinModel>,
    eventMap: HashMap<Int, Any> = hashMapOf()
) : BaseSpinAdapter<EventTypeSpinModel, EventTypeListItemBinding>(
    context = context,
    data = data.toMutableList(),
    eventMap = eventMap,
    itemId = R.layout.event_type_list_item,
    variableId = BR.data
)
