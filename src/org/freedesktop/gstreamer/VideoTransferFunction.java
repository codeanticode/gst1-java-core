package org.freedesktop.gstreamer;

// http://gstreamer.freedesktop.org/data/doc/gstreamer/head/gst-plugins-base-libs/html/gst-plugins-base-libs-gstvideo.html#GstVideoTransferFunction
public enum VideoTransferFunction {
  GST_VIDEO_TRANSFER_UNKNOWN,
  /** unknown transfer function **/
   
  GST_VIDEO_TRANSFER_GAMMA10,
  /** linear RGB, gamma 1.0 curve **/
   
  GST_VIDEO_TRANSFER_GAMMA18,
  /** Gamma 1.8 curve **/
   
  GST_VIDEO_TRANSFER_GAMMA20,
  /** Gamma 2.0 curve **/
   
  GST_VIDEO_TRANSFER_GAMMA22,
  /** Gamma 2.2 curve **/
   
  GST_VIDEO_TRANSFER_BT709,
  /** Gamma 2.2 curve with a linear segment in the lower range **/
   
  GST_VIDEO_TRANSFER_SMPTE240M,
  /** Gamma 2.2 curve with a linear segment in the lower range **/
   
  GST_VIDEO_TRANSFER_SRGB,
  /** Gamma 2.4 curve with a linear segment in the lower range **/
   
  GST_VIDEO_TRANSFER_GAMMA28,
  /** Gamma 2.8 curve **/
   
  GST_VIDEO_TRANSFER_LOG100,
  /** Logarithmic transfer characteristic 100:1 range **/
   
  GST_VIDEO_TRANSFER_LOG316,
  /** Logarithmic transfer characteristic 316.22777:1 range **/
   
  GST_VIDEO_TRANSFER_BT2020_12,
  /** Gamma 2.2 curve with a linear segment in the lower range. Used for BT.2020 
   * with 12 bits per component. Since: 1.6.
   */
}
