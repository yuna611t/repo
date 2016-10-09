using System;
using System.Threading;
using System.Globalization;
using Microsoft.AspNetCore.Razor.TagHelpers;

namespace MyFirstApp.TagHelpers
{

    [HtmlTargetElement(Attributes = "date-value")]
    public class DateFormatTagHelper : TagHelper
    {

        public DateTime DateValue { get; set; }
        public string DateCulture { get; set; }

        public override void Process(TagHelperContext context, TagHelperOutput output)
        {
            output.Attributes.RemoveAll("date-culture");
            string formatedDate = formatDate(DateValue);
            output.Content.SetHtmlContent(formatedDate);
        }

        private string formatDate(DateTime dt) {
            string formatedDate = dt.ToString();

            if (!String.IsNullOrEmpty(DateCulture)) {
                if (DateCulture.Equals("ja"))
                {
                    setCultureInfo(DateCulture);
                    formatedDate = dt.ToString("yyyy年MM月dd日");
                }
            }
            return formatedDate;
        }

        private void setCultureInfo(string cultureCode)
        {
            #if DNX451
                        Thread.CurrentThread.CurrentCulture = new CultureInfo(cultureCode);
            #elif DNXCORE50
                        CultureInfo.CurrentCulture = new CultureInfo(cultureCode);
            #endif

        }



    }
}
