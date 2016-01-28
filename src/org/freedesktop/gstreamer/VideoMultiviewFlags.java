package org.freedesktop.gstreamer;

public enum VideoMultiviewFlags {
  GST_VIDEO_MULTIVIEW_FLAGS_NONE,
  /** No flags **/
   
  GST_VIDEO_MULTIVIEW_FLAGS_RIGHT_VIEW_FIRST,
  /** For stereo streams, the normal arrangement of left and right views is reversed. **/
   
  GST_VIDEO_MULTIVIEW_FLAGS_LEFT_FLIPPED,
  /** The left view is vertically mirrored.**/
   
  GST_VIDEO_MULTIVIEW_FLAGS_LEFT_FLOPPED,
  /** The left view is horizontally mirrored.**/
   
  GST_VIDEO_MULTIVIEW_FLAGS_RIGHT_FLIPPED,
  /** The right view is vertically mirrored.**/
   
  GST_VIDEO_MULTIVIEW_FLAGS_RIGHT_FLOPPED,
  /** The right view is horizontally mirrored.**/
   
  GST_VIDEO_MULTIVIEW_FLAGS_HALF_ASPECT,
  /** For frame-packed multiview modes, indicates that the individual views 
   * have been encoded with half the true width or height and should be scaled 
   * back up for display. This flag is used for overriding input layout 
   * interpretation by adjusting pixel-aspect-ratio. For side-by-side, column 
   * interleaved or checkerboard packings, the pixel width will be doubled. 
   * For row interleaved and top-bottom encodings, pixel height will be doubled.
   */
   
  GST_VIDEO_MULTIVIEW_FLAGS_MIXED_MONO;
  /** The video stream contains both mono and multiview portions, signalled on 
   * each buffer by the absence or presence of the GST_VIDEO_BUFFER_FLAG_MULTIPLE_VIEW buffer flag.
   */
}
