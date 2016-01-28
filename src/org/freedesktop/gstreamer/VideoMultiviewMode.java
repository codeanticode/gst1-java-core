package org.freedesktop.gstreamer;

public enum VideoMultiviewMode {
  GST_VIDEO_MULTIVIEW_MODE_NONE,
  /** A special value indicating no multiview information. 
   * Used in GstVideoInfo and other places to indicate that no specific multiview 
   * handling has been requested or provided. This value is never carried on caps.
   */
   
  GST_VIDEO_MULTIVIEW_MODE_MONO,
  /** All frames are monoscopic. **/
   
  GST_VIDEO_MULTIVIEW_MODE_LEFT,
  /** All frames represent a left-eye view. **/
   
  GST_VIDEO_MULTIVIEW_MODE_RIGHT,
  /** All frames represent a right-eye view. **/
   
  GST_VIDEO_MULTIVIEW_MODE_SIDE_BY_SIDE,
  /** Left and right eye views are provided in the left and right half of the frame respectively. **/
   
  GST_VIDEO_MULTIVIEW_MODE_SIDE_BY_SIDE_QUINCUNX,
  /** Left and right eye views are provided in the left and right half of the 
   * frame, but have been sampled using quincunx method, with half-pixel offset between the 2 views.
   */
   
  GST_VIDEO_MULTIVIEW_MODE_COLUMN_INTERLEAVED,
  /** Alternating vertical columns of pixels represent the left and right eye 
   * view respectively.
   */
   
  GST_VIDEO_MULTIVIEW_MODE_ROW_INTERLEAVED,
  /** Alternating horizontal rows of pixels represent the left and right eye view 
   * respectively.
   */
   
  GST_VIDEO_MULTIVIEW_MODE_TOP_BOTTOM,
  /** The top half of the frame contains the left eye, and the bottom half the right eye. **/
   
  GST_VIDEO_MULTIVIEW_MODE_CHECKERBOARD,
  /** Pixels are arranged with alternating pixels representing left and right 
   * eye views in a checkerboard fashion.
   */
   
  GST_VIDEO_MULTIVIEW_MODE_FRAME_BY_FRAME,
  /** Left and right eye views are provided in separate frames alternately. **/
   
  GST_VIDEO_MULTIVIEW_MODE_MULTIVIEW_FRAME_BY_FRAME,
  /** Multiple independent views are provided in separate frames in sequence. 
   * This method only applies to raw video buffers at the moment. Specific view 
   * identification is via the GstVideoMultiviewMeta and GstVideoMeta(s) on raw video buffers.
   */
   
  GST_VIDEO_MULTIVIEW_MODE_SEPARATED;
  /** Multiple views are provided as separate GstMemory framebuffers attached 
   * to each GstBuffer, described by the GstVideoMultiviewMeta and GstVideoMeta(s)
   */
}
