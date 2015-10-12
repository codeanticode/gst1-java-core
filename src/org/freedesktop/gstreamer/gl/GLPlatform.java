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

import java.util.HashMap;
import java.util.Map;
import org.freedesktop.gstreamer.lowlevel.EnumMapper;
import org.freedesktop.gstreamer.lowlevel.GstGLAPI;
import org.freedesktop.gstreamer.lowlevel.GstNative;
import org.freedesktop.gstreamer.lowlevel.IntegerEnum;

/**
 *
 * @author andres
 */
public enum GLPlatform implements IntegerEnum {
    GST_GL_PLATFORM_NONE(0),
  
    GST_GL_PLATFORM_EGL(1 << 0),
  
    GST_GL_PLATFORM_GLX(1 << 1),
  
    GST_GL_PLATFORM_WGL(1 << 2),
  
    GST_GL_PLATFORM_CGL(1 << 3),
  
    GST_GL_PLATFORM_EAGL(1 << 4),

    GST_GL_PLATFORM_ANY(0xffffffff);
          
    
    GLPlatform(int type) {
        this.type = type;
        GstGLAPI glAPI = GstNative.load(GstGLAPI.class);
        this.name = glAPI.gst_gl_platform_to_string(this);
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
     * Gets a GLPlatform that corresponds to the native integer value.
     * 
     * @param type the native value of the type.
     * @return a GLPlatform.
     */
    public static final GLPlatform valueOf(int type) {
        return EnumMapper.getInstance().valueOf(type, GLPlatform.class);
    } 
    
    /**
     * Gets a GLPlatform that corresponds to the name
     * 
     * @param name the gstreamer name of the type.
     * @return a GLPlatform.
     */
    public static final GLPlatform forName(String name) {
        GLPlatform type = MapHolder.typeMap.get(name);
        return type != null ? type : GST_GL_PLATFORM_NONE;
    }
    private final int type;
    private final String name;
    private static final class MapHolder {
        private static final Map<String, GLPlatform> typeMap = new HashMap<String, GLPlatform>();
        static {
            for (GLPlatform t : GLPlatform.values()) {
                typeMap.put(t.getName(), t);
            }
        }
    }
}
