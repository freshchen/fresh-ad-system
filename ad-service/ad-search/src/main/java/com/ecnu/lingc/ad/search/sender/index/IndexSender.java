package com.ecnu.lingc.ad.search.sender.index;

import com.alibaba.fastjson.JSON;
import com.ecnu.lingc.ad.common.dump.table.*;
import com.ecnu.lingc.ad.search.handler.AdLevelDataHandler;
import com.ecnu.lingc.ad.search.index.DataLevel;
import com.ecnu.lingc.ad.search.mysql.dto.MySqlRowData;
import com.ecnu.lingc.ad.search.sender.ISender;
import com.ecnu.lingc.ad.search.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/8 21:29
 * @Author: Ling Chen
 * @Description:
 */
@Component("indexSender")
public class IndexSender implements ISender {
    private static final Logger log = LoggerFactory.getLogger(IndexSender.class);

    public IndexSender() {
    }

    public void sender(MySqlRowData rowData) {
        String level = rowData.getLevel();
        if (DataLevel.LEVEL2.getLevel().equals(level)) {
            this.Level2RowData(rowData);
        } else if (DataLevel.LEVEL3.getLevel().equals(level)) {
            this.Level3RowData(rowData);
        } else if (DataLevel.LEVEL4.getLevel().equals(level)) {
            this.Level4RowData(rowData);
        } else {
            log.error("MysqlRowData ERROR: {}", JSON.toJSONString(rowData));
        }

    }

    private void Level2RowData(MySqlRowData rowData) {
        ArrayList creativeTables;
        Iterator var3;
        Map fieldValeMap;
        if (rowData.getTableName().equals("ad_plan")) {
            creativeTables = new ArrayList();
            var3 = rowData.getFieldValueMap().iterator();

            while(var3.hasNext()) {
                fieldValeMap = (Map)var3.next();
                AdPlanTable planTable = new AdPlanTable();
                fieldValeMap.forEach((k, v) -> {
                    byte var4 = -1;
                    switch(k.hashCode()) {
                        case -1573629589:
                            if (k.equals("start_date")) {
                                var4 = 3;
                            }
                            break;
                        case -147132913:
                            if (k.equals("user_id")) {
                                var4 = 1;
                            }
                            break;
                        case 3355:
                            if (k.equals("id")) {
                                var4 = 0;
                            }
                            break;
                        case 1725067410:
                            if (k.equals("end_date")) {
                                var4 = 4;
                            }
                            break;
                        case 1878462920:
                            if (k.equals("plan_status")) {
                                var4 = 2;
                            }
                    }

                    switch(var4) {
                        case 0:
                            planTable.setId(Long.valueOf((String) v));
                            break;
                        case 1:
                            planTable.setUserId(Long.valueOf((String) v));
                            break;
                        case 2:
                            planTable.setPlanStatus(Integer.valueOf((Integer) v));
                            break;
                        case 3:
                            planTable.setStartDate(CommonUtils.parseStringDate((String) v));
                            break;
                        case 4:
                            planTable.setEndDate(CommonUtils.parseStringDate((String) v));
                    }

                });
                creativeTables.add(planTable);
            }

            creativeTables.forEach((p) -> {
                AdLevelDataHandler.handleLevel2((AdCreativeTable) p, rowData.getOpType());
            });
        } else if (rowData.getTableName().equals("ad_creative")) {
            creativeTables = new ArrayList();
            var3 = rowData.getFieldValueMap().iterator();

            while(var3.hasNext()) {
                fieldValeMap = (Map)var3.next();
                AdCreativeTable creativeTable = new AdCreativeTable();
                fieldValeMap.forEach((k, v) -> {
                    byte var4 = -1;
                    switch(k.hashCode()) {
                        case -1310903082:
                            if (k.equals("audit_status")) {
                                var4 = 5;
                            }
                            break;
                        case -1221029593:
                            if (k.equals("height")) {
                                var4 = 3;
                            }
                            break;
                        case -1149107374:
                            if (k.equals("material_type")) {
                                var4 = 2;
                            }
                            break;
                        case 3355:
                            if (k.equals("id")) {
                                var4 = 0;
                            }
                            break;
                        case 116079:
                            if (k.equals("url")) {
                                var4 = 6;
                            }
                            break;
                        case 3575610:
                            if (k.equals("type")) {
                                var4 = 1;
                            }
                            break;
                        case 113126854:
                            if (k.equals("width")) {
                                var4 = 4;
                            }
                    }

                    switch(var4) {
                        case 0:
                            creativeTable.setAdId(Long.valueOf((String) v));
                            break;
                        case 1:
                            creativeTable.setType(Integer.valueOf((Integer) v));
                            break;
                        case 2:
                            creativeTable.setMaterialType(Integer.valueOf((Integer) v));
                            break;
                        case 3:
                            creativeTable.setHeight(Integer.valueOf((Integer) v));
                            break;
                        case 4:
                            creativeTable.setWidth(Integer.valueOf((Integer) v));
                            break;
                        case 5:
                            creativeTable.setAuditStatus(Integer.valueOf((Integer) v));
                            break;
                        case 6:
                            creativeTable.setAdUrl((String) v);
                    }

                });
                creativeTables.add(creativeTable);
            }

            creativeTables.forEach((c) -> {
                AdLevelDataHandler.handleLevel2((AdCreativeTable) c, rowData.getOpType());
            });
        }

    }

    private void Level3RowData(MySqlRowData rowData) {
        ArrayList creativeUnitTables;
        Iterator var3;
        Map fieldValueMap;
        if (rowData.getTableName().equals("ad_unit")) {
            creativeUnitTables = new ArrayList();
            var3 = rowData.getFieldValueMap().iterator();

            while(var3.hasNext()) {
                fieldValueMap = (Map)var3.next();
                AdUnitTable unitTable = new AdUnitTable();
                fieldValueMap.forEach((k, v) -> {
                    byte var4 = -1;
                    switch(k.hashCode()) {
                        case -493901327:
                            if (k.equals("plan_id")) {
                                var4 = 3;
                            }
                            break;
                        case 3355:
                            if (k.equals("id")) {
                                var4 = 0;
                            }
                            break;
                        case 1066205328:
                            if (k.equals("position_type")) {
                                var4 = 2;
                            }
                            break;
                        case 1382807309:
                            if (k.equals("unit_status")) {
                                var4 = 1;
                            }
                    }

                    switch(var4) {
                        case 0:
                            unitTable.setUnitId(Long.valueOf((String) v));
                            break;
                        case 1:
                            unitTable.setUnitStatus(Integer.valueOf((Integer) v));
                            break;
                        case 2:
                            unitTable.setPositionType(Integer.valueOf((Integer) v));
                            break;
                        case 3:
                            unitTable.setPlanId(Long.valueOf((String) v));
                    }

                });
                creativeUnitTables.add(unitTable);
            }

            creativeUnitTables.forEach((u) -> {
                AdLevelDataHandler.handleLevel3((AdCreativeUnitTable) u, rowData.getOpType());
            });
        } else if (rowData.getTableName().equals("creative_unit")) {
            creativeUnitTables = new ArrayList();
            var3 = rowData.getFieldValueMap().iterator();

            while(var3.hasNext()) {
                fieldValueMap = (Map)var3.next();
                AdCreativeUnitTable creativeUnitTable = new AdCreativeUnitTable();
                fieldValueMap.forEach((k, v) -> {
                    byte var4 = -1;
                    switch(k.hashCode()) {
                        case -358273109:
                            if (k.equals("creative_id")) {
                                var4 = 0;
                            }
                            break;
                        case -286525002:
                            if (k.equals("unit_id")) {
                                var4 = 1;
                            }
                    }

                    switch(var4) {
                        case 0:
                            creativeUnitTable.setAdId(Long.valueOf((String) v));
                            break;
                        case 1:
                            creativeUnitTable.setUnitId(Long.valueOf((String) v));
                    }

                });
                creativeUnitTables.add(creativeUnitTable);
            }

            creativeUnitTables.forEach((u) -> {
                AdLevelDataHandler.handleLevel3((AdCreativeUnitTable) u, rowData.getOpType());
            });
        }

    }

    private void Level4RowData(MySqlRowData rowData) {
        String var2 = rowData.getTableName();
        byte var3 = -1;
        switch(var2.hashCode()) {
            case -1926077235:
                if (var2.equals("ad_unit_district")) {
                    var3 = 0;
                }
                break;
            case -167061078:
                if (var2.equals("ad_unit_it")) {
                    var3 = 1;
                }
                break;
            case 83970250:
                if (var2.equals("ad_unit_keyword")) {
                    var3 = 2;
                }
        }

        switch(var3) {
            case 0:
                List <AdUnitDistrictTable> districtTables = new ArrayList();
                Iterator var10 = rowData.getFieldValueMap().iterator();

                while(var10.hasNext()) {
                    Map<String, String> fieldValueMap = (Map)var10.next();
                    AdUnitDistrictTable districtTable = new AdUnitDistrictTable();
                    fieldValueMap.forEach((k, v) -> {
                        byte var4 = -1;
                        switch(k.hashCode()) {
                            case -987485392:
                                if (k.equals("province")) {
                                    var4 = 1;
                                }
                                break;
                            case -286525002:
                                if (k.equals("unit_id")) {
                                    var4 = 0;
                                }
                                break;
                            case 3053931:
                                if (k.equals("city")) {
                                    var4 = 2;
                                }
                        }

                        switch(var4) {
                            case 0:
                                districtTable.setUnitId(Long.valueOf(v));
                                break;
                            case 1:
                                districtTable.setProvince(v);
                                break;
                            case 2:
                                districtTable.setCity(v);
                        }

                    });
                    districtTables.add(districtTable);
                }

                districtTables.forEach((d) -> {
                    AdLevelDataHandler.handleLevel4(d, rowData.getOpType());
                });
                break;
            case 1:
                List<AdUnitItTable> itTables = new ArrayList();
                Iterator var11 = rowData.getFieldValueMap().iterator();

                while(var11.hasNext()) {
                    Map<String, String> fieldValueMap = (Map)var11.next();
                    AdUnitItTable itTable = new AdUnitItTable();
                    fieldValueMap.forEach((k, v) -> {
                        byte var4 = -1;
                        switch(k.hashCode()) {
                            case -1178833274:
                                if (k.equals("it_tag")) {
                                    var4 = 1;
                                }
                                break;
                            case -286525002:
                                if (k.equals("unit_id")) {
                                    var4 = 0;
                                }
                        }

                        switch(var4) {
                            case 0:
                                itTable.setUnitId(Long.valueOf(v));
                                break;
                            case 1:
                                itTable.setItTag(v);
                        }

                    });
                    itTables.add(itTable);
                }

                itTables.forEach((i) -> {
                    AdLevelDataHandler.handleLevel4(i, rowData.getOpType());
                });
                break;
            case 2:
                List<AdUnitKeywordTable> keywordTables = new ArrayList();
                Iterator var7 = rowData.getFieldValueMap().iterator();

                while(var7.hasNext()) {
                    Map<String, String> fieldValueMap = (Map)var7.next();
                    AdUnitKeywordTable keywordTable = new AdUnitKeywordTable();
                    fieldValueMap.forEach((k, v) -> {
                        byte var4 = -1;
                        switch(k.hashCode()) {
                            case -814408215:
                                if (k.equals("keyword")) {
                                    var4 = 1;
                                }
                                break;
                            case -286525002:
                                if (k.equals("unit_id")) {
                                    var4 = 0;
                                }
                        }

                        switch(var4) {
                            case 0:
                                keywordTable.setUnitId(Long.valueOf(v));
                                break;
                            case 1:
                                keywordTable.setKeyword(v);
                        }

                    });
                    keywordTables.add(keywordTable);
                }

                keywordTables.forEach((k) -> {
                    AdLevelDataHandler.handleLevel4(k, rowData.getOpType());
                });
        }

    }
}

