package library;

import java.io.IOException;

import collections.ResourceReader;
import collections.Book;
import collections.Dvd;
import collections.Hashtable;
import collections.Media;
import collections.User;
import collections.BinarySearchTree;

public class LibraryController {
	private Hashtable<String, Media> media;
	private BinarySearchTree<String, User> users;
	
	private LogInController logInController = new LogInController();
	
	public User getLoggedInUser() {
		return logInController.getUser();
	}
	
	public User getUser(String key) {
		return users.get(key);
	}
	
	public Media getMedia(String key) {
		return media.get(key);
	}
	
	public void loadUsers(String path) {
		users = new BinarySearchTree<String, User>();
		String[] values = new String[0];
		int counter = 0;
		try {
			values = ResourceReader.getValuesOnLine(path, counter);
			while(values != null) {
				values = ResourceReader.getValuesOnLine(path, counter);
				if(values != null) users.put(values[0], new User(values[0], values[1], values[2]));
				counter += 1;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public int getAmountOfMedia(String path) {
		String[] values = new String[0];
		int counter = 0;
		try {
			values = ResourceReader.getValuesOnLine(path, counter);
			while(values != null) {
				values = ResourceReader.getValuesOnLine(path, counter);
				counter += 1;
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return counter;
	}
	
	public void loadMedia(String path) {
		String[] values = new String[0];
		
		int size = getAmountOfMedia(path);
		
		media = new Hashtable<String, Media>(size);
		
		try {
			for(int i = 0; i < size-1; i++) {
				values = ResourceReader.getValuesOnLine(path, i);	
				if(values[0].equals("Dvd")) {
					String[] actors = new String[values.length-4];
					for(int j = 0; j < actors.length; j++) { 
						actors[j] = values[j+4];
					}
					media.put(values[1], new Dvd(values[1], values[2], Integer.parseInt(values[3]), actors));
				} else {
					media.put(values[1], new Book(values[1], values[3], Integer.parseInt(values[4]), values[2]));
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
