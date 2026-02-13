package Homework17.Task1;

public class Television {
    private int currentChannel;
    private int maxChannels;
    private Channel[] channels;

    public Television(int channel) {
        this(channel, 7);
    }

    public Television(int currentChannel, int maxChannels) {
        this.maxChannels = maxChannels;
        this.currentChannel = currentChannel;
        channels = new Channel[maxChannels];
        channelName();
    }

    public void getNextChannel() {
        if (currentChannel + 1 > maxChannels){
            currentChannel = 1;
        } else {
            currentChannel = currentChannel + 1;
        }
    }

    public void getPreviousChannel(){
        if (currentChannel - 1 == 0){
            currentChannel = maxChannels;
        } else {
            currentChannel = currentChannel - 1;
        }
    }

    public void getChannelByNumber(int channel) {
        currentChannel = channel;
    }

    public void currentChannel() {
        System.out.println("Current channel is: " + currentChannel);
    }

    public String getChannelNameByNumber() {
        return String.format("<<<<<< %s >>>>>>%n%s%n", currentChannel, channels[currentChannel - 1].getName());
    }

    private void channelName() {
        String[] channelNames = {"KTRK", "ELTR", "Cartoon Network", "Jetix", "Nickelodeon", "2x2", "TNT"};
        for (int i = 0; i < maxChannels; i++) {
            Channel channel = new Channel(channelNames[i]);
            channels[i] = channel;
        }
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        this.currentChannel = currentChannel;
    }

    public int getMaxChannels() {
        return maxChannels;
    }

    public void setMaxChannels(int maxChannels) {
        this.maxChannels = maxChannels;
    }

    public Channel[] getChannels() {
        return channels;
    }

    public void setChannels(Channel[] channels) {
        this.channels = channels;
    }
}
