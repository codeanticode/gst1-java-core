package org.freedesktop.gstreamer;

import static org.freedesktop.gstreamer.lowlevel.GstVideoAPI.GSTVIDEO_API;

import java.awt.Dimension;
import org.freedesktop.gstreamer.lowlevel.GstVideoAPI;
import org.freedesktop.gstreamer.lowlevel.GstVideoAPI.VideoFrameStruct;
import org.freedesktop.gstreamer.lowlevel.GstVideoAPI.VideoInfoStruct;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

import org.freedesktop.gstreamer.lowlevel.GValueAPI.GValue;

public class Video {
    public static int GST_VIDEO_MAX_PLANES = GstVideoAPI.GST_VIDEO_MAX_PLANES;
  
    private Video() {
    }

        
    /**
     * A convenience function to retrieve a GValue holding the framerate from the caps on a pad.
     *
     * The pad needs to have negotiated caps containing a framerate property.
     * 
     * @param pad
     * @return video framerate, otherwise null if the pad has no configured caps or the configured caps do not contain a framerate.
     */
    public static Fraction getVideoFrameRate(Pad pad) {
    	final GValue gvalue = GSTVIDEO_API.gst_video_frame_rate(pad);
    	return gvalue != null ? Fraction.objectFor(gvalue) : null;
    }
    
    /**
     * Inspect the caps of the provided pad and retrieve the width and height of the video frames it is configured for.
     *
     * The pad needs to have negotiated caps containing width and height properties.
     * @param pad
     * @return dimensions of the video, otherwise null if the video size could not be retrieved
     */
    public static Dimension getVideoSize(Pad pad) {
    	int [] width = { 0 };
    	int [] height = { 0 };
    	return GSTVIDEO_API.gst_video_get_size(pad, width, height) ? new Dimension(width [0], height [0]) : null;
    }

    public static VideoInfoStruct.ByReference getVideoInfo(Caps caps) {
      
      VideoInfoStruct.ByReference info = GSTVIDEO_API.gst_video_info_new();
      boolean res = GSTVIDEO_API.gst_video_info_from_caps(info, caps);
      if (res) {
        System.err.println("info.width: " + info.width);
        System.err.println("info.height: " + info.height);        
        return info;
      }
      else return null;
      
      
      /*
      // Following:
      // http://jnaexamples.blogspot.com/2012/03/java-native-access-is-easy-way-to.html
      PointerByReference pref = new PointerByReference();
      boolean res = GSTVIDEO_API.gst_video_info_from_caps(pref, caps);
      if (res) {
        Pointer ptr = pref.getValue();
        VideoInfoStruct info = new VideoInfoStruct(ptr);
        System.err.println("info.width: " + info.width);
        System.err.println("info.height: " + info.height);        
        return info;        
      } else return null;  
      */    
      
      /*
      VideoInfoStruct info = new VideoInfoStruct();
      boolean res = GSTVIDEO_API.gst_video_info_from_caps(info, caps);
      if (res) {
        System.err.println("info.width: " + info.width);
        System.err.println("info.height: " + info.height);        
        return info;
      }
      else return null; 
      */
    }
    
    public static VideoFrameStruct.ByReference mapVideoFrame(VideoInfoStruct.ByReference info,
                                                             Buffer buffer,
                                                             int flags) {
      VideoFrameStruct.ByReference frame = new VideoFrameStruct.ByReference();
      boolean res = GSTVIDEO_API.gst_video_frame_map(frame, info, buffer, flags);
      if (res) { 
        return frame;
      } else return null;
    }
    
    public static void unmapVideoFrame(VideoFrameStruct.ByReference frame) {
      GSTVIDEO_API.gst_video_frame_unmap(frame);
    }
}
