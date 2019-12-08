package me.ccrama.redditslide.test;

import com.danikula.videocache.HttpProxyCacheServer;

import org.junit.Test;

import me.ccrama.redditslide.Reddit;
import me.ccrama.redditslide.util.GifUtils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class GifUtilsTest {

    @Test
    public void proxyShouldBeNull() {
        Reddit.proxy = null;

        assertNull(GifUtils.getProxy());
    }

    @Test
    public void proxyShouldNotBeNull() {
        Reddit.proxy = mock(HttpProxyCacheServer.class);

        assertNotNull(GifUtils.getProxy());
    }

    @Test
    public void muxShouldReturnFalseWhenAllParamsAreNull() {
        assertFalse(GifUtils.mux(null, null, null));
    }

    @Test
    public void muxShouldReturnFalseWhenOnlyVideoFileIsNotNull() {
        assertFalse(GifUtils.mux("/home/pali/Downloads/Tandem.mp4", null, null));
    }

    @Test
    public void muxShouldReturnFalseWhenVideoAndAudioFileIsNotNull() {
        assertFalse(GifUtils.mux("/home/pali/Downloads/Tandem.mp4", "/home/pali/Downloads/Tandem.mp3", null));
    }

    @Test
    public void muxShouldReturnTrueWhenAllParamsAreValid() {
        assertTrue(GifUtils.mux("/home/pali/Downloads/Tandem.mp4", "/home/pali/Downloads/Tandem.mp3", "/home/pali/Downloads/T.mp4"));
    }
}
