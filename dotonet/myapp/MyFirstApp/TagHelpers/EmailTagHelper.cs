using System;
using Microsoft.AspNetCore.Razor.TagHelpers;

namespace MyFirstApp.TagHelpers
{
    public class EmailTagHelper : TagHelper
    {
        public string MailTo { get; set; }

        public override void Process(TagHelperContext context, TagHelperOutput output)
        {
            output.TagName = "a";
            var address = MailTo + "@" + "sample.com";
            output.Attributes.SetAttribute("href", "mailto:" + address);
            output.Content.SetContent(address);
        }
    }
}
