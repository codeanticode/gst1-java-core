package org.freedesktop.gstreamer;

// http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoColorPrimaries
public enum VideoColorPrimaries {
  GST_VIDEO_COLOR_PRIMARIES_UNKNOWN,
  /** unknown color primaries **/
   
  GST_VIDEO_COLOR_PRIMARIES_BT709,
  /** BT709 primaries **/
   
  GST_VIDEO_COLOR_PRIMARIES_BT470M,
  /** BT470M primaries **/
   
  GST_VIDEO_COLOR_PRIMARIES_BT470BG,
  /** BT470BG primaries **/
   
  GST_VIDEO_COLOR_PRIMARIES_SMPTE170M,
  /** SMPTE170M primaries **/
   
  GST_VIDEO_COLOR_PRIMARIES_SMPTE240M,
  /** SMPTE240M primaries **/
   
  GST_VIDEO_COLOR_PRIMARIES_FILM,
  /** Generic film **/
   
  GST_VIDEO_COLOR_PRIMARIES_BT2020;
  /** BT2020 primaries. Since: 1.6. **/
}
