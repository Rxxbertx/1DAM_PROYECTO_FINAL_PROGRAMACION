package objetosModificados;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamNoHead extends ObjectOutputStream {

	public ObjectOutputStreamNoHead(FileOutputStream acceso) throws IOException {

	}

	public void writeStreamHeader() {

	}

}
