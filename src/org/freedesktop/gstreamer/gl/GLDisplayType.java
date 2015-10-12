/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.freedesktop.gstreamer.gl;

import java.util.HashMap;
import java.util.Map;
import org.freedesktop.gstreamer.lowlevel.EnumMapper;
import org.freedesktop.gstreamer.lowlevel.GstGLAPI;
import org.freedesktop.gstreamer.lowlevel.GstGLDisplayAPI;
import org.freedesktop.gstreamer.lowlevel.GstNative;
import org.freedesktop.gstreamer.lowlevel.IntegerEnum;

/**
 *
 * @author andres
 */
public enum GLDisplayType implements IntegerEnum {   
    GST_GL_DISPLAY_TYPE_NONE(0),
    GST_GL_DISPLAY_TYPE_X11(1 << 0),
    GST_GL_DISPLAY_TYPE_WAYLAND(1 << 1),
    GST_GL_DISPLAY_TYPE_COCOA(1 << 2),
    GST_GL_DISPLAY_TYPE_WIN32(1 << 3),
    GST_GL_DISPLAY_TYPE_DISPMANX(1 << 4),
    GST_GL_DISPLAY_TYPE_EGL(1 << 5),
    GST_GL_DISPLAY_TYPE_ANY(0xffffffff); 
    
    GLDisplayType(int type) {
        this.type = type;
//        GstGLDisplayAPI glDispAPI = GstNative.load(GstGLDisplayAPI.class);
//        this.name = glDispAPI.gst_gl_api_to_string(this);
            
        if (type == 0) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_NONE_NAME;
        } else if (type == 1 << 0) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_X11_NAME;
        } else if (type == 1 << 1) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_WAYLAND_NAME;
        } else if (type == 1 << 2) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_COCOA_NAME;
        } else if (type == 1 << 3) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_WIN32_NAME;
        } else if (type == 1 << 4) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_DISPMANX_NAME;
        } else if (type == 1 << 5) {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_EGL_NAME;
        } else {
            this.name = GstGLDisplayAPI.GST_GL_DISPLAY_TYPE_ANY_NAME;
        }
    }     
  
    /**
     * Gets the native integer value for this type.
     * 
     * @return the native gstreamer value.
     */
    public int intValue() {
        return type;
    }
    
    /**
     * Gets the name of this message type.
     * 
     * @return the name of the message type.
     */
    public String getName() {
        return name;
    }
    
       /**
     * Gets a GLDisplayType that corresponds to the native integer value.
     * 
     * @param type the native value of the type.
     * @return a GLDisplayType.
     */
    public static final GLDisplayType valueOf(int type) {
        return EnumMapper.getInstance().valueOf(type, GLDisplayType.class);
    } 
    
    /**
     * Gets a GLDisplayType that corresponds to the name
     * 
     * @param name the gstreamer name of the type.
     * @return a GLDisplayType.
     */
    public static final GLDisplayType forName(String name) {
        GLDisplayType type = MapHolder.typeMap.get(name);
        return type != null ? type : GST_GL_DISPLAY_TYPE_NONE;
    }
    private final int type;
    private final String name;
    private static final class MapHolder {
        private static final Map<String, GLDisplayType> typeMap = new HashMap<String, GLDisplayType>();
        static {
            for (GLDisplayType t : GLDisplayType.values()) {
                typeMap.put(t.getName(), t);
            }
        }
    }   
}
