<p>如果我们可以将<strong>小写字母</strong>插入模式串&nbsp;<code>pattern</code>&nbsp;得到待查询项&nbsp;<code>query</code>，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）</p>

<p>给定待查询列表&nbsp;<code>queries</code>，和模式串&nbsp;<code>pattern</code>，返回由布尔值组成的答案列表&nbsp;<code>answer</code>。只有在待查项&nbsp;<code>queries[i]</code> 与模式串&nbsp;<code>pattern</code> 匹配时，&nbsp;<code>answer[i]</code>&nbsp;才为 <code>true</code>，否则为 <code>false</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
<strong>输出：</strong>[true,false,true,true,false]
<strong>示例：</strong>
"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
<strong>输出：</strong>[true,false,true,false,false]
<strong>解释：</strong>
"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输出：</strong>queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
<strong>输入：</strong>[false,true,false,false,false]
<strong>解释： </strong>
"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ol> 
 <li><code>1 &lt;= queries.length &lt;= 100</code></li> 
 <li><code>1 &lt;= queries[i].length &lt;= 100</code></li> 
 <li><code>1 &lt;= pattern.length &lt;= 100</code></li> 
 <li>所有字符串都仅由大写和小写英文字母组成。</li> 
</ol>

<div><li>👍 74</li><li>👎 0</li></div>