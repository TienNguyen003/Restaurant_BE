package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.Service.chat.GroupMembersService;
import com.project.restaurantly.dto.request.chat.GroupChatMemberRequest;
import com.project.restaurantly.dto.response.ApiResponse;
import com.project.restaurantly.dto.response.chat.GroupChatMemberResponse;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}member-group")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class GroupMembersController {
    GroupMembersService memberService;

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_ADD')")
    @PostMapping
    ApiResponse<GroupChatMemberResponse> create(@RequestBody @Valid GroupChatMemberRequest request) {
        return ApiResponse.<GroupChatMemberResponse>builder()
                .result(memberService.create(request))
                .build();
    }

//    @PreAuthorize("@requiredPermission.checkPermission('PERM_VIEW')")
    @GetMapping("/get")
    ApiResponse<List<GroupChatMemberResponse>> getAll() {
        return ApiResponse.<List<GroupChatMemberResponse>>builder()
                .result(memberService.getAll())
                .build();
    }

    @GetMapping("/by")
    ApiResponse<GroupChatMemberResponse> getMenu(@RequestParam(name = "id", required = false) long id) {
        return ApiResponse.<GroupChatMemberResponse>builder()
                .result(memberService.get(id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_EDIT')")
    @PutMapping()
    ApiResponse<GroupChatMemberResponse> updateMenu(@RequestBody @Valid GroupChatMemberRequest request, @RequestParam long id) {
        return ApiResponse.<GroupChatMemberResponse>builder()
                .result(memberService.update(request, id))
                .build();
    }

    //    @PreAuthorize("@requiredPermission.checkPermission('PERM_DELETE')")
    @DeleteMapping
    ApiResponse<String> delete(@RequestParam(name = "id", required = false) long id) {
        memberService.delete(id);
        return ApiResponse.<String>builder()
                .result("Member has been deleted")
                .build();
    }
}
