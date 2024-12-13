package br.com.rodrigo.nearby.ui.util

import com.google.android.gms.maps.model.LatLng

fun findSouthWestPoint(points: List<LatLng>): LatLng {
    if(points.isEmpty()) return LatLng(0.0, 0.0)

    var southWestPoint = points[0]

    for(point in points) {
        if(point.latitude < southWestPoint.latitude ||
            (point.latitude == southWestPoint.latitude && point.longitude < southWestPoint.longitude)) {
            southWestPoint = point
        }
    }

    return southWestPoint
}

fun findNorthWestPoint(points: List<LatLng>): LatLng {
    if(points.isEmpty()) return LatLng(0.0, 0.0)

    var northWestPoint = points[0]

    for(point in points) {
        if(point.latitude > northWestPoint.latitude ||
            (point.latitude == northWestPoint.latitude && point.longitude > northWestPoint.longitude)) {
            northWestPoint = point
        }
    }

    return northWestPoint
}