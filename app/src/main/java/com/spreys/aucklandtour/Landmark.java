package com.spreys.aucklandtour;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 14/08/16
 *         Project: AucklandTour
 *         Contact by: vlad@spreys.com
 */
public class Landmark {
    @NonNull
    private final String name;
    @NonNull
    private final String location;

    @Nullable
    private Integer drawableResourceId;

    public Landmark(@NonNull String name, @NonNull String location, @Nullable Integer drawableResourceId) {
        this.name = name;
        this.location = location;
        this.drawableResourceId = drawableResourceId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    @Nullable
    public Integer getDrawableResourceId() {
        return drawableResourceId;
    }
}
