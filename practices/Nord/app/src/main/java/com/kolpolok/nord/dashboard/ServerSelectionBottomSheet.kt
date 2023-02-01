package com.kolpolok.nord.dashboard

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.widget.FrameLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kolpolok.nord.databinding.FragmentBottomsheetServersSelectionBinding

class ServerSelectionBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomsheetServersSelectionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomsheetServersSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        bottomSheetHeightAlign()
    }


    private fun bottomSheetHeightAlign() {
        val dialog: BottomSheetDialog? = dialog as BottomSheetDialog?
        dialog?.setCanceledOnTouchOutside(true)
        val bottomSheet: FrameLayout? =
            dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)
        if (bottomSheet != null) {
            BottomSheetBehavior.from(bottomSheet).state = BottomSheetBehavior.STATE_COLLAPSED
            with(BottomSheetBehavior.from(bottomSheet)) {
                this.maxHeight =
                    (getDeviceMetrics(requireContext())?.heightPixels?.times(0.75))?.toInt() ?: 0
                skipCollapsed = true
                isHideable = true
            }
        }
    }

    private fun getDeviceMetrics(context: Context): DisplayMetrics? {
        val metrics = DisplayMetrics()
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = wm.defaultDisplay
        display.getMetrics(metrics)
        return metrics
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        initClickListener()
        // binding.closeBtn.setOnClickListener { this.dismiss() }
    }

    private fun initClickListener() {

    }

    private fun initData() {

    }

    private fun initView() {

    }

}