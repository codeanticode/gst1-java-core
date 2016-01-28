package org.freedesktop.gstreamer;

// http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoColorMatrix
public enum VideoColorMatrix {
  GST_VIDEO_COLOR_MATRIX_UNKNOWN,
  /** unknown matrix **/
 
  GST_VIDEO_COLOR_MATRIX_RGB,
  /** identity matrix **/
 
  GST_VIDEO_COLOR_MATRIX_FCC,
  /** FCC color matrix **/
 
  GST_VIDEO_COLOR_MATRIX_BT709,
  /** ITU-R BT.709 color matrix **/
 
  GST_VIDEO_COLOR_MATRIX_BT601,
  /** ITU-R BT.601 color matrix **/
 
  GST_VIDEO_COLOR_MATRIX_SMPTE240M,
  /** SMPTE 240M color matrix **/
 
  GST_VIDEO_COLOR_MATRIX_BT2020;
  /** ITU-R BT.2020 color matrix. Since: 1.6. **/
}
