/*
 * GStreamer
 * Copyright (C) 2012 Matthew Waters <ystreet00@gmail.com>
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA 02110-1301, USA.
 */
package org.freedesktop.gstreamer.gl;

import com.sun.jna.Pointer;
import java.util.Arrays;
import java.util.List;
import org.freedesktop.gstreamer.GError;
import org.freedesktop.gstreamer.GstObject;
import org.freedesktop.gstreamer.lowlevel.GObjectAPI;
import org.freedesktop.gstreamer.lowlevel.GThread;
import org.freedesktop.gstreamer.lowlevel.GstAPI;
import org.freedesktop.gstreamer.lowlevel.GstGLContextAPI;
import org.freedesktop.gstreamer.lowlevel.GstNative;

/**
 *
 * @author andres
 */
public class GLContext extends GstObject {
    public static final String GTYPE_NAME = "GstGLContext";
    
    private static final GstGLContextAPI gst = GstNative.load(GstGLContextAPI.class);
    
    public GLContext(Initializer init) {
        super(init);
    }    
    
    public static GLContext createNew(GLDisplay display) {
        return gst.gst_gl_context_new(display);
    }

    public static GLContext createNewWrapped(GLDisplay display, int handle, GLPlatform contextType, GLAPI availableApis) {
        return gst.gst_gl_context_new_wrapped(display, handle, contextType, availableApis);
    }
    
    public boolean activate(boolean activate) {
        return gst.gst_gl_context_activate(this, activate);
    }

    public GThread getThread() {
        return gst.gst_gl_context_get_thread(this);
    }
    
    public static GLContext getCurrent() {
        return gst.gst_gl_context_get_current();
    }
    
    public GLDisplay getDisplay() {
        return gst.gst_gl_context_get_display(this);
    }
    
    public Pointer getProcAddress(String name) {
        return gst.gst_gl_context_get_proc_address(this, name);
    }
    
    public GLPlatform getGLPlatform() {
        return gst.gst_gl_context_get_gl_platform(this);
    }
    
    public GLAPI getGLAPI() {
        return gst.gst_gl_context_get_gl_api(this);
    }
    
    public Pointer getGLContext() {
        return gst.gst_gl_context_get_gl_context(this);
    }
    
    public boolean canShare(GLContext otherContext) {
        return gst.gst_gl_context_can_share(this, otherContext);
    }
    
    public boolean create(GLContext otherContext, GError[] error) {
        return gst.gst_gl_context_create(this, otherContext, error);
    }

    public void destroy() {
        gst.gst_gl_context_destroy(this);
    }
    
    static public Pointer getProcAddress(GLAPI glApi, String name) {
        return gst.gst_gl_context_default_get_proc_address(glApi, name);
    }
    
    public boolean setWindow(GLWindow window) {
        return gst.gst_gl_context_set_window(this, window);
    }
    
    public GLWindow getWindow(GLContext context) {
        return gst.gst_gl_context_get_window(this);
    }
    
    public void getGLVersion(int[] maj, int[] min) {
        gst.gst_gl_context_get_gl_version(this, maj, min);    
    }
    
    public boolean checkGLVersion(GLAPI api, int maj, int min) {
        return gst.gst_gl_context_check_gl_version(this, api, maj, min);
    }
    
    public boolean checkFeature(String feature) {
        return gst.gst_gl_context_check_feature(this, feature);
    }
    
    static public int getCurrentGLContext(GLPlatform platform) {
        return gst.gst_gl_context_get_current_gl_context(platform);
    }
    
    static public GLAPI getCurrentGLAPI(int[] major, int[] minor) {
        return gst.gst_gl_context_get_current_gl_api(major, minor);
    }

    public boolean fillInfo(GError[] error) {
        return gst.gst_gl_context_fill_info(this, error);
    }
    
    public static final class GstGLContextClass extends com.sun.jna.Structure {
        public GObjectAPI.GObjectClass parent_class;
        
        public volatile Pointer get_current_context;
        public volatile Pointer get_gl_context;
        public volatile Pointer get_gl_api;
        public volatile Pointer get_gl_platform;
        public volatile Pointer get_proc_address;
        public volatile Pointer activate;
        public volatile Pointer choose_format;
        public volatile Pointer create_context;
        public volatile Pointer destroy_context;
        public volatile Pointer swap_buffers;
        public volatile Pointer check_feature;
        
        public volatile Pointer[] _gst_reserved = new Pointer[GstAPI.GST_PADDING];        
        
        @Override
        protected List getFieldOrder() {
            return Arrays.asList(new String[]{
                "parent_class", 
                "get_current_context", "get_gl_context",
                "get_gl_api", "get_gl_platform",
                "get_proc_address", "activate",
                "choose_format", "create_context",
                "destroy_context", "swap_buffers", 
                "check_feature",
                
                "_gst_reserved"
            });
        }
    }
}

