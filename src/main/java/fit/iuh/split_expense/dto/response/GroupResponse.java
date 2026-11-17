/*
 * @ (#) GroupResponse .java     1.0     11/17/2026
 * Copyright (c) 2026 IUH.All Rights Reserved.
 */
package fit.iuh.split_expense.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/*
 *@description: this is a class to test the GroupResponse class
 *@author: Bao Nguyen
 *@Date: 11/17/2026
 *@version:      1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupResponse {
    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
}
