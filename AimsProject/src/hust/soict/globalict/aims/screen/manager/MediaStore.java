package hust.soict.globalict.aims.screen.manager;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel{
private Media media;
public MediaStore(Media media)
{
	this.media = media;
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	
	JLabel title = new JLabel(media.getTitle());
	title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
	title.setAlignmentX(CENTER_ALIGNMENT);
	
	JLabel cost = new JLabel("" + media.getCost() + " $");
	cost.setAlignmentX(CENTER_ALIGNMENT);
	
	JPanel container = new JPanel();
	container.setLayout(new FlowLayout(FlowLayout.CENTER));
	
	if(media instanceof Playable)
	{
		JButton playButton = new JButton("Play");
		playButton.addActionListener(e -> {
	        Playable playable = (Playable) media;
	        try {
	        	playable.play();

	        	JOptionPane.showMessageDialog(
	        			this,
	        			"Playing: " + media.getTitle(),
	        			"Play",
	        			JOptionPane.INFORMATION_MESSAGE
	        	);
	        } catch (PlayerException exception) {
	        	JOptionPane.showMessageDialog(
	        			this,
	        			exception.getMessage(),
	        			"Play error",
	        			JOptionPane.ERROR_MESSAGE
	        	);
	        }
	    });
		container.add(playButton);
		
	}
	
	this.add(Box.createVerticalGlue());
	this.add(title);
	this.add(cost);
	this.add(Box.createVerticalGlue());
	this.add(container);
	
	this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
}
}
