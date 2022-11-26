package entity;

import java.util.Objects;

public class Document {

    private int document_id;
    private String filePath;
    private String fileName;
    private String fileType;

    public Document() {
    }

    public Document(int document_id, String filePath, String fileName, String fileType) {
        this.document_id = document_id;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.document_id;
        hash = 59 * hash + Objects.hashCode(this.filePath);
        hash = 59 * hash + Objects.hashCode(this.fileName);
        hash = 59 * hash + Objects.hashCode(this.fileType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Document other = (Document) obj;
        if (this.document_id != other.document_id) {
            return false;
        }
        if (!Objects.equals(this.filePath, other.filePath)) {
            return false;
        }
        if (!Objects.equals(this.fileName, other.fileName)) {
            return false;
        }
        if (!Objects.equals(this.fileType, other.fileType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Document{" + "document_id=" + document_id + ", filePath=" + filePath + ", fileName=" + fileName + ", fileType=" + fileType + '}';
    }

}
