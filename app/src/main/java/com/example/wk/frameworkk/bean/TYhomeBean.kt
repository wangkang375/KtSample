package com.example.wk.frameworkk.bean

data class TYhomeBean(
        val issueList: List<Issue>,
        val nextPageUrl: String,
        val nextPublishTime: Long,
        val newestIssueType: String,
        val dialog: Any
)