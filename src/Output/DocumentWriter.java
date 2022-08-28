package Output;

import java.util.List;

public interface DocumentWriter {
	public List<String> write(String filepath, List<String> contents);
}
