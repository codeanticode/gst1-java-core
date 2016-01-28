package org.freedesktop.gstreamer;

public enum VideoChromaSite {
  /** unknown cositing **/
  GST_VIDEO_CHROMA_SITE_UNKNOWN,
  
  /** no cositing **/
  GST_VIDEO_CHROMA_SITE_NONE,
    
  /** chroma is horizontally cosited **/
  GST_VIDEO_CHROMA_SITE_H_COSITED,
    
  /** chroma is vertically cosited **/
  GST_VIDEO_CHROMA_SITE_V_COSITED,
  
  /** choma samples are sited on alternate lines **/ 
  GST_VIDEO_CHROMA_SITE_ALT_LINE,
    
  /** chroma samples cosited with luma samples **/
  GST_VIDEO_CHROMA_SITE_COSITED,  
  
  /** jpeg style cositing, also for mpeg1 and mjpeg **/
  GST_VIDEO_CHROMA_SITE_JPEG,
  
  /** mpeg2 style cositing **/
  GST_VIDEO_CHROMA_SITE_MPEG2,
  
  /** DV style cositing **/
  GST_VIDEO_CHROMA_SITE_DV;  
}
