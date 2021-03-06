package com.example.andrey.myapplication1.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import ch.prokopovi.ConnectionBroadcastReceiver;
import ch.prokopovi.IntentFactory;
import ch.prokopovi.PrefsUtil;
import com.example.andrey.myapplication1.struct.Master.WidgetSize;
import com.example.andrey.myapplication1.struct.WidgetPreferences;

public abstract class AbstractWidgetProvider extends AppWidgetProvider {

	interface ClickUiMap {
		Integer getLaunchAppClickId();

		Integer getUpdClickId();

		Integer getCfgClickId();

		WidgetSize getWidgetSize();
	}

	protected static class WidgetUiMap implements ClickUiMap {
		private final int layoutId;
		private final Integer launchAppClickId;
		private final Integer updClickId;
		private final Integer cfgClickId;

		private final WidgetSize widgetSize;
		private final List<RateUiMap> rates = new ArrayList<AbstractWidgetProvider.RateUiMap>();
		private final int prividerThumbId;
		private final int timeUpdatedId;
		private final int rateTypeId;

		private final MessageUiMap messageUiMap;

		public WidgetUiMap(int layoutId, Integer launchAppClickId,
				Integer updClickId, Integer cfgClickId, WidgetSize widgetSize,
				Integer timeUpdatedId, int rateTypeId, int prividerThumbId,
				MessageUiMap messageUiMap) {
			super();
			this.layoutId = layoutId;
			this.launchAppClickId = launchAppClickId;
			this.updClickId = updClickId;
			this.cfgClickId = cfgClickId;
			this.widgetSize = widgetSize;
			this.prividerThumbId = prividerThumbId;
			this.timeUpdatedId = timeUpdatedId;
			this.rateTypeId = rateTypeId;
			this.messageUiMap = messageUiMap;
		}

		public int getLayoutId() {
			return this.layoutId;
		}

		@Override
		public Integer getLaunchAppClickId() {
			return this.launchAppClickId;
		}

		@Override
		public Integer getUpdClickId() {
			return this.updClickId;
		}

		@Override
		public Integer getCfgClickId() {
			return this.cfgClickId;
		}

		@Override
		public WidgetSize getWidgetSize() {
			return this.widgetSize;
		}

		public int getPrividerThumbId() {
			return this.prividerThumbId;
		}

		public List<RateUiMap> getRates() {
			return this.rates;
		}

		public int getTimeUpdatedId() {
			return this.timeUpdatedId;
		}

		public int getRateTypeId() {
			return this.rateTypeId;
		}

		public MessageUiMap getMessageUiMap() {
			return this.messageUiMap;
		}

	}

	protected static class RateValueUiMap {
		private final Integer directionId;
		private final int currentId;
		private final Integer dynamicId;

		public RateValueUiMap(Integer directionId, int currentId,
				Integer dynamicId) {
			super();
			this.directionId = directionId;
			this.currentId = currentId;
			this.dynamicId = dynamicId;
		}

		public int getCurrentId() {
			return this.currentId;
		}

		public Integer getDirectionId() {
			return this.directionId;
		}

		public Integer getDynamicId() {
			return this.dynamicId;
		}
	}

	protected static class RateUiMap {
		private final Integer currencyTextId;
		private RateValueUiMap buy;
		private RateValueUiMap sell;

		public RateUiMap(Integer currencyTextId) {
			this.currencyTextId = currencyTextId;
		}

		public RateValueUiMap getBuy() {
			return this.buy;
		}

		public Integer getCurrencyTextId() {
			return this.currencyTextId;
		}

		public RateValueUiMap getSell() {
			return this.sell;
		}

		public void setBuy(RateValueUiMap buy) {
			this.buy = buy;
		}

		public void setSell(RateValueUiMap sell) {
			this.sell = sell;
		}
	}

	protected static class MessageUiMap implements ClickUiMap {
		private final int layoutId;
		private final Integer clickableId;
		private final int textId;
		private final WidgetSize widgetSize;

		public MessageUiMap(int layoutId, Integer clickableId, int textId,
				WidgetSize widgetSize) {
			super();
			this.layoutId = layoutId;
			this.clickableId = clickableId;
			this.textId = textId;
			this.widgetSize = widgetSize;
		}

		public int getLayoutId() {
			return this.layoutId;
		}

		public int getTextId() {
			return this.textId;
		}

		@Override
		public Integer getUpdClickId() {
			return this.clickableId;
		}

		@Override
		public Integer getCfgClickId() {
			return this.clickableId;
		}

		@Override
		public WidgetSize getWidgetSize() {
			return this.widgetSize;
		}

		@Override
		public Integer getLaunchAppClickId() {
			return null;
		}

	}

	private static final String LOG_TAG = "AbstractWidgetProvider";

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {

		Log.d(LOG_TAG, "onDeleted ids " + Arrays.toString(appWidgetIds));

		for (int widgetId : appWidgetIds) {
			PrefsUtil.cleanUp(context, widgetId);
		}

		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);

		Log.d(LOG_TAG, "onUpdate ids " + Arrays.toString(appWidgetIds));

		// if widgets are newly installed or updated (no connection changes were
		// met), the
		// alarm scheduler adjustment is needed
		ConnectionBroadcastReceiver.updateState(context);
		// ---

		for (int i = 0; i < appWidgetIds.length; i++) {

			int appWidgetId = appWidgetIds[i];

			Log.d(LOG_TAG, "appWidgetId " + appWidgetId);

			try {
				WidgetPreferences prefs = PrefsUtil.load(context, appWidgetId);

				if (prefs == null)
					continue;

				PendingIntent pendingIntent = IntentFactory
						.createWeakUpdateServiceIntent(context, prefs);

				pendingIntent.send();
			} catch (Exception e) {
				Log.e(LOG_TAG, "error during widget update ", e);
				continue;
			}
		}

	}
}
