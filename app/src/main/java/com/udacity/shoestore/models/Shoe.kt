package com.udacity.shoestore.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR;

data class Shoe(
    private var _name: String,
    private var _size: Double,
    private var _company: String,
    private var _description: String
) : BaseObservable() {
    var name: String
        @Bindable get() = _name
        set(value) {
            _name = value
            notifyPropertyChanged(BR.name)
        }
    var size: Double
        @Bindable get() = _size
        set(value) {
            _size = value
            notifyPropertyChanged(BR.size)
        }
    var company: String
        @Bindable get() = _company
        set(value) {
            _company = value
            notifyPropertyChanged(BR.company)
        }
    var description: String
        @Bindable get() = _description
        set(value) {
            _description = value
            notifyPropertyChanged(BR.description)
        }
}