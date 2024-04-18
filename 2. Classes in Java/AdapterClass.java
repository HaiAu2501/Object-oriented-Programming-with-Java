// Xem xét ví dụ sau:
/*
 * - Chúng ta muốn kết nối một ứng dụng với một hệ thống nhạc.
 * - Ứng dụng của chúng ta có một interface để điều kiển nhạc.
 * - Nhưng hệ thống nhạc sử dụng các API không tương thích với interface của chúng ta.
 */

// Interface để điều khiển nhạc.
interface MusicPlayerControl {
    void play(); // Phát nhạc.

    void stop(); // Dừng phát nhạc.

    void pause(); // Tạm dừng phát nhạc.
}

// Hệ thống nhạc sử dụng các API không tương thích với interface của chúng ta.
class AdvancedMusicPlayer {
    public void startPlayback() {
        System.out.println("Playback started.");
    }

    public void stopPlayback() {
        System.out.println("Playback stopped.");
    }

    public void pausePlayback() {
        System.out.println("Playback paused.");
    }
}

// #################################################################
// ################ Cách 1: Sử dụng Inner Class ####################
// #################################################################

// Sử dụng nội lớp để kết nối ứng dụng với hệ thống nhạc.
class MusicSystem {
    private AdvancedMusicPlayer player = new AdvancedMusicPlayer();

    private class MusicPlayerAdapter implements MusicPlayerControl {
        public void play() {
            player.startPlayback();
        }

        public void stop() {
            player.stopPlayback();
        }

        public void pause() {
            player.pausePlayback();
        }
    }

    public MusicPlayerControl getController() {
        return new MusicPlayerAdapter();
    }
}

// ################################################################
// ################ Cách 2: Sử dụng Adapter Class #################
// ################################################################
class MusicPlayerAdapter implements MusicPlayerControl {
    private AdvancedMusicPlayer player;

    public MusicPlayerAdapter(AdvancedMusicPlayer player) {
        this.player = player;
    }

    public void play() {
        player.startPlayback();
    }

    public void stop() {
        player.stopPlayback();
    }

    public void pause() {
        player.pausePlayback();
    }
}

// Nếu không sử dụng inner class, chúng ta phải tạo một lớp adapter riêng biệt.
// Điều này có thể làm tăng độ phức tạp của cấu trúc dự án và làm cho các thành
// phần phụ thuộc lẫn nhau một cách không cần thiết.

// ##################### Lớp thực thi #########################

public class AdapterClass {
    public static void main(String[] args) {
        // Sử dụng Inner Class
        MusicSystem system = new MusicSystem();
        MusicPlayerControl controller = system.getController();

        controller.play();
        controller.pause();
        controller.stop();

        // Sử dụng Adapter Class
        AdvancedMusicPlayer player = new AdvancedMusicPlayer();
        MusicPlayerControl newController = new MusicPlayerAdapter(player);

        newController.play();
        newController.pause();
        newController.stop();
    }
}
