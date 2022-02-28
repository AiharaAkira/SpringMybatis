package com.mz.pj.dataroom;

import java.util.List;

public interface DataRoomMapper {


	public int upload(DataRoomFile df);

	public int delete(DataRoomFile df);

	public List<DataRoomFile> get();

	
	
	
	
}
