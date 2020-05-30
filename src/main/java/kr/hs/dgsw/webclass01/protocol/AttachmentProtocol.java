package kr.hs.dgsw.webclass01.protocol;

import lombok.Data;

@Data
public class AttachmentProtocol {
    private String stroredPath;
    private String originalName;

    public AttachmentProtocol(String stroredPath, String originalName) {
        this.stroredPath = stroredPath;
        this.originalName = originalName;
    }
}
