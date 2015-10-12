/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.freedesktop.gstreamer.gl;

import org.freedesktop.gstreamer.GError;
import org.freedesktop.gstreamer.GstObject;
import org.freedesktop.gstreamer.lowlevel.GThread;
import org.freedesktop.gstreamer.lowlevel.GstGLDisplayAPI;
import org.freedesktop.gstreamer.lowlevel.GstNative;
import org.freedesktop.gstreamer.lowlevel.GstContext;

/**
 *
 * @author andres
 */
public class GLDisplay extends GstObject {
    public static final String GTYPE_NAME = "GstGLDisplay";

    private static final GstGLDisplayAPI gst = GstNative.load(GstGLDisplayAPI.class);
    
    public GLDisplay(Initializer init) {
        super(init);
    }
    
    public static GLDisplay createNew() {
        return gst.gst_gl_display_new();
    }
    
    public int getHandle() {
        return gst.gst_gl_display_get_handle(this);
    }
    
    public GLDisplayType getHandleType() {
        return gst.gst_gl_display_get_handle_type(this);
    }
    
    public void filterGLAPI(GLAPI api) {
        gst.gst_gl_display_filter_gl_api(this, api);
    }

    public GLAPI getGLAPI() {
        return gst.gst_gl_display_get_gl_api(this);
    }    
    
    public GLAPI getGLAPIUnlocked() {
        return gst.gst_gl_display_get_gl_api_unlocked(this);
    }
    
    static public void setGLDisplay(GstContext context, GLDisplay[] display) {
        gst.gst_context_set_gl_display(context, display);
    }
    
    public boolean createContext(GLContext other_context, GLContext[] p_context, GError[] error) {
        return gst.gst_gl_display_create_context(this, other_context, p_context, error);
    }
    
    public GLContext getGLContextForThread(GThread thread) {
        return gst.gst_gl_display_get_gl_context_for_thread(this, thread);
    }
    
    public boolean addContext(GLContext context) {
        return gst.gst_gl_display_add_context(this, context);
    }
}
