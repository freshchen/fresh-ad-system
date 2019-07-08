package com.ecnu.lingc.ad.search.index;

import com.alibaba.fastjson.JSON;
import com.ecnu.lingc.ad.common.dump.table.*;
import com.ecnu.lingc.ad.search.handler.AdLevelDataHandler;
import com.ecnu.lingc.ad.search.mysql.constant.OpType;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/8 21:18
 * @Author: Ling Chen
 * @Description:
 */
@Component
@DependsOn({"dataTable"})
public class IndexFileLoader {

    public IndexFileLoader() {
    }

    @PostConstruct
    public void init() {
        List<String> adPlanStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_plan.data"));
        adPlanStrings.forEach((p) -> {
            AdLevelDataHandler.handleLevel2((AdPlanTable)JSON.parseObject(p, AdPlanTable.class), OpType.ADD);
        });
        List<String> adCreativeStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_creative.data"));
        adCreativeStrings.forEach((c) -> {
            AdLevelDataHandler.handleLevel2((AdCreativeTable)JSON.parseObject(c, AdCreativeTable.class), OpType.ADD);
        });
        List<String> adUnitStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_unit.data"));
        adUnitStrings.forEach((u) -> {
            AdLevelDataHandler.handleLevel3((AdUnitTable)JSON.parseObject(u, AdUnitTable.class), OpType.ADD);
        });
        List<String> adCreativeUnitStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_creative_unit.data"));
        adCreativeUnitStrings.forEach((cu) -> {
            AdLevelDataHandler.handleLevel3((AdCreativeUnitTable)JSON.parseObject(cu, AdCreativeUnitTable.class), OpType.ADD);
        });
        List<String> adUnitDistrictStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_unit_district.data"));
        adUnitDistrictStrings.forEach((d) -> {
            AdLevelDataHandler.handleLevel4((AdUnitDistrictTable) JSON.parseObject(d, AdUnitDistrictTable.class), OpType.ADD);
        });
        List<String> adUnitItStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_unit_it.data"));
        adUnitItStrings.forEach((i) -> {
            AdLevelDataHandler.handleLevel4((AdUnitItTable)JSON.parseObject(i, AdUnitItTable.class), OpType.ADD);
        });
        List<String> adUnitKeywordStrings = this.loadDumpData(String.format("%s%s", "/var/data/mysql/mysql_data/", "ad_unit_keyword.data"));
        adUnitKeywordStrings.forEach((k) -> {
            AdLevelDataHandler.handleLevel4((AdUnitKeywordTable)JSON.parseObject(k, AdUnitKeywordTable.class), OpType.ADD);
        });
    }

    private List<String> loadDumpData(String fileName) {
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            Throwable var3 = null;

            List var4;
            try {
                var4 = (List)br.lines().collect(Collectors.toList());
            } catch (Throwable var14) {
                var3 = var14;
                throw var14;
            } finally {
                if (br != null) {
                    if (var3 != null) {
                        try {
                            br.close();
                        } catch (Throwable var13) {
                            var3.addSuppressed(var13);
                        }
                    } else {
                        br.close();
                    }
                }

            }

            return var4;
        } catch (IOException var16) {
            throw new RuntimeException(var16.getMessage());
        }
    }
}
