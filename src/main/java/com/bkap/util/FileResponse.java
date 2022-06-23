package com.bkap.util;

public class FileResponse {
	private String fileName;
	private String fileUri;
	private String type;
	private long size;
	
	public FileResponse() {
	}
	public FileResponse(String fileName, String fileUri, String type, long size) {
		this.fileName = fileName;
		this.fileUri = fileUri;
		this.type = type;
		this.size = size;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUri() {
		return fileUri;
	}
	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
}
