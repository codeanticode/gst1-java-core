package org.freedesktop.gstreamer;

public enum VideoFormatFlags {
  /** The video format is YUV, components are numbered 0=Y, 1=U, 2=V. **/
  GST_VIDEO_FORMAT_FLAG_YUV,
  
  /** The video format is RGB, components are numbered 0=R, 1=G, 2=B. **/ 
  GST_VIDEO_FORMAT_FLAG_RGB,
  
  /** The video is gray, there is one gray component with index 0. **/ 
  GST_VIDEO_FORMAT_FLAG_GRAY,
  
  /** The video format has an alpha components with the number 3. **/ 
  GST_VIDEO_FORMAT_FLAG_ALPHA,
  
  /** The video format has data stored in little endianness. **/ 
  GST_VIDEO_FORMAT_FLAG_LE,
  
  /** The video format has a palette. The palette is stored in the second plane and indexes are stored in the first plane. **/ 
  GST_VIDEO_FORMAT_FLAG_PALETTE,
  
  /** The video format has a complex layout that can't be described with the usual information in the GstVideoFormatInfo. **/ 
  GST_VIDEO_FORMAT_FLAG_COMPLEX,
  
  /** This format can be used in a GstVideoFormatUnpack and GstVideoFormatPack function. **/ 
  GST_VIDEO_FORMAT_FLAG_UNPACK,
  
  /** The format is tiled, there is tiling information in the last plane. **/ 
  GST_VIDEO_FORMAT_FLAG_TILED;
}
