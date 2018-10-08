
package com.ms.warehouse.manage.entity;

import java.util.List;
import java.util.Map;

import com.ms.warehouse.common.entity.BaseEntity;

/**
 * 首页信息
 * @author ms
 * @Date 2018-07-09 18:27:43
 * @since 1.0
 */
public class HomeEntity extends BaseEntity {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
    private Map<Long,Long> ctEntrymainorder;
    private Map<Long,Long> ctOutmainorder;
    private Map<Long,Long> ctPositionadjust;
    private Map<Long,Long> ctStockcheck;
    private List<InventoryBiEntity> ctInventoryBi;

    private Long countOutmainorderDay;
    private Long countEntryDay;
    private Long countInventoryDay;
    
    
	public HomeEntity(Map<Long, Long> ctEntrymainorder, Map<Long, Long> ctOutmainorder,
			Map<Long, Long> ctPositionadjust, Map<Long, Long> ctStockcheck, List<InventoryBiEntity> ctInventoryBi,
			Long countOutmainorderDay, Long countEntryDay, Long countInventoryDay) {
		super();
		this.ctEntrymainorder = ctEntrymainorder;
		this.ctOutmainorder = ctOutmainorder;
		this.ctPositionadjust = ctPositionadjust;
		this.ctStockcheck = ctStockcheck;
		this.ctInventoryBi = ctInventoryBi;
		this.countOutmainorderDay = countOutmainorderDay;
		this.countEntryDay = countEntryDay;
		this.countInventoryDay = countInventoryDay;
	}
	public HomeEntity() {
		super();
	}
	public Map<Long, Long> getCtEntrymainorder() {
		return ctEntrymainorder;
	}
	public void setCtEntrymainorder(Map<Long, Long> ctEntrymainorder) {
		this.ctEntrymainorder = ctEntrymainorder;
	}
	public Map<Long, Long> getCtOutmainorder() {
		return ctOutmainorder;
	}
	public void setCtOutmainorder(Map<Long, Long> ctOutmainorder) {
		this.ctOutmainorder = ctOutmainorder;
	}
	public Map<Long, Long> getCtPositionadjust() {
		return ctPositionadjust;
	}
	public void setCtPositionadjust(Map<Long, Long> ctPositionadjust) {
		this.ctPositionadjust = ctPositionadjust;
	}
	public Map<Long, Long> getCtStockcheck() {
		return ctStockcheck;
	}
	public void setCtStockcheck(Map<Long, Long> ctStockcheck) {
		this.ctStockcheck = ctStockcheck;
	}
	public List<InventoryBiEntity> getCtInventoryBi() {
		return ctInventoryBi;
	}
	public void setCtInventoryBi(List<InventoryBiEntity> ctInventoryBi) {
		this.ctInventoryBi = ctInventoryBi;
	}
	public Long getCountOutmainorderDay() {
		return countOutmainorderDay;
	}
	public void setCountOutmainorderDay(Long countOutmainorderDay) {
		this.countOutmainorderDay = countOutmainorderDay;
	}
	public Long getCountEntryDay() {
		return countEntryDay;
	}
	public void setCountEntryDay(Long countEntryDay) {
		this.countEntryDay = countEntryDay;
	}
	public Long getCountInventoryDay() {
		return countInventoryDay;
	}
	public void setCountInventoryDay(Long countInventoryDay) {
		this.countInventoryDay = countInventoryDay;
	}
}
