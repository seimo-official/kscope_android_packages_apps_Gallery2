/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.filtershow.filters;

import androidx.annotation.NonNull;

import com.android.gallery3d.filtershow.editors.ImageOnlyEditor;

import org.codeaurora.gallery.R;

public class FilterImageBorderRepresentation extends FilterRepresentation {
    private int mDrawableResource;

    public FilterImageBorderRepresentation(int drawableResource) {
        super("ImageBorder");
        setFilterClass(ImageFilterBorder.class);
        mDrawableResource = drawableResource;
        setFilterType(FilterRepresentation.TYPE_BORDER);
        setTextId(R.string.borders);
        setEditorId(ImageOnlyEditor.ID);
        setShowParameterValue(false);
    }

    @NonNull
    public String toString() {
        return "FilterBorder: " + getName();
    }

    @Override
    public FilterRepresentation copy() {
        FilterImageBorderRepresentation representation =
                new FilterImageBorderRepresentation(mDrawableResource);
        copyAllParameters(representation);
        return representation;
    }

    @Override
    protected void copyAllParameters(FilterRepresentation representation) {
        super.copyAllParameters(representation);
        representation.useParametersFrom(this);
    }

    public void useParametersFrom(FilterRepresentation a) {
        if (a instanceof FilterImageBorderRepresentation) {
            FilterImageBorderRepresentation representation = (FilterImageBorderRepresentation) a;
            setName(representation.getName());
            setDrawableResource(representation.getDrawableResource());
        }
    }

    @Override
    public boolean equals(FilterRepresentation representation) {
        if (!super.equals(representation)) {
            return false;
        }
        if (representation instanceof FilterImageBorderRepresentation) {
            FilterImageBorderRepresentation border = (FilterImageBorderRepresentation) representation;
            return border.mDrawableResource == mDrawableResource;
        }
        return false;
    }

    @Override
    public int getTextId() {
        return R.string.none;
    }

    public boolean allowsSingleInstanceOnly() {
        return true;
    }

    public int getDrawableResource() {
        return mDrawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        mDrawableResource = drawableResource;
    }
}
