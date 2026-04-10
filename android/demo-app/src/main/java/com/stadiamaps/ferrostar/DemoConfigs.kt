package com.stadiamaps.ferrostar

import uniffi.ferrostar.CourseFiltering
import uniffi.ferrostar.NavigationCachingConfig
import uniffi.ferrostar.NavigationControllerConfig
import uniffi.ferrostar.Route
import uniffi.ferrostar.RouteDeviation
import uniffi.ferrostar.RouteDeviationDetector
import uniffi.ferrostar.RouteDeviationTracking
import uniffi.ferrostar.StepAdvanceCondition
import uniffi.ferrostar.TripState
import uniffi.ferrostar.UniffiWithHandle
import uniffi.ferrostar.WaypointAdvanceMode
import uniffi.ferrostar.stepAdvanceDistanceEntryAndExit
import uniffi.ferrostar.stepAdvanceDistanceFromStep
import uniffi.ferrostar.stepAdvanceDistanceToEndOfStep
import uniffi.ferrostar.stepAdvanceManual

fun NavigationControllerConfig.Companion.demoConfig(): NavigationControllerConfig {
  return NavigationControllerConfig(
      WaypointAdvanceMode.WaypointWithinRange(100.0),
      stepAdvanceDistanceEntryAndExit(30u, 5u, 32u),
      // our config
      //stepAdvanceDistanceFromStep(10u, 25u, false),
      stepAdvanceDistanceToEndOfStep(10u, 32u),
      RouteDeviationTracking.StaticThreshold(15U, 50.0),
      CourseFiltering.SNAP_TO_ROUTE)
}

fun NavigationCachingConfig.Companion.demoConfig(): NavigationCachingConfig {
  return NavigationCachingConfig(
      cacheIntervalSeconds = 300L,
      maxAgeSeconds = 86400L,
  )
}
